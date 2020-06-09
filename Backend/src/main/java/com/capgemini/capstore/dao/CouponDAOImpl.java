package com.capgemini.capstore.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CouponBean;
import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.exception.CapstoreException;

@Repository
@SuppressWarnings("unchecked")
public class CouponDAOImpl implements CouponDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<CouponBean> showAllCoupons() {
		List<CouponBean> couponList = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "FROM CouponBean";
		Query query = entityManager.createQuery(jpql);
		try {
			couponList = query.getResultList();
		} catch (Exception e) {
			throw new CapstoreException("No coupons are present");
		}
		return couponList;
	}

	@Override
	public boolean addCoupon(CouponBean couponBean) {
		boolean isAdded = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(couponBean);
			entityTransaction.commit();
			entityManager.close();
			isAdded = true;
		} catch (Exception e) {
			throw new CapstoreException("Unable to add product");
		}
		return isAdded;
	}

	@Override
	public void deleteCoupon() {
		LocalDate currentDate = LocalDate.now();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			List<CouponBean> couponList = showAllCoupons();
			if (couponList != null) {
				for (CouponBean couponBean : couponList) {
					System.err.println("Inside for ");
					System.err.println(couponBean.getCouponExpireDate());
					System.err.println(currentDate);
					if (currentDate.compareTo(couponBean.getCouponExpireDate()) <= 1 || (couponBean.getCount() == 0)) {
						System.out.println("value matched");
						// entityManager.remove(couponBean);
						int couponId = couponBean.getCouponId();
						System.err.println(couponId);
						String jpql = "DELETE CouponBean where couponId =: couponId";
						Query query = entityManager.createQuery(jpql);
						query.setParameter("couponId", couponId);
						System.out.println("After remove");
					}
				}
				entityTransaction.commit();
			}
		} catch (Exception e) {
			throw new CapstoreException("No coupons get deleted");
		}
	}

	@Override
	public boolean updateCoupon(CouponBean couponBean) {
		boolean isUpdated = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		CouponBean couponBean2 = entityManager.find(CouponBean.class, couponBean.getCouponId());
		if (couponBean2 != null) {
			String couponCode = couponBean.getCouponCode();
			if (couponCode != null && !couponCode.isEmpty()) {
				couponBean2.setCouponCode(couponCode);
			}
			String couponInformation = couponBean.getCouponInformation();
			if (couponCode != null) {
				couponBean2.setCouponInformation(couponInformation);
			}
			double discount = couponBean.getDiscount();
			if (discount >= 0.0) {
				couponBean2.setDiscount(discount);
			}
			LocalDate couponExpireDate = couponBean.getCouponExpireDate();
			if (couponExpireDate != null) {
				couponBean2.setCouponExpireDate(couponExpireDate);
			}
			int count = couponBean.getCount();
			if (count >= 0) {
				couponBean2.setCount(count);
			}
			double originalBill = couponBean.getOriginalBill();
			if (originalBill >= 0.0) {
				couponBean2.setOriginalBill(originalBill);
			}
			try {
				entityTransaction.begin();
				// updating hotel details
				entityManager.persist(couponBean2);
				entityTransaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				throw new CapstoreException("No records get updated");
			}
			entityManager.close();
		}
		return isUpdated;
	}

	@Override
	public boolean applyCoupon(int couponId, String email) {
		boolean isApplied = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		double newPrice = 0.0;
		int count = 0;

		// to get coupon table
		CouponBean couponBean = entityManager.find(CouponBean.class, couponId);

		// To get OrderBean for particular user
		String jpql = "From OrderDetailsBean where email =:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		OrderDetailsBean orderBean = (OrderDetailsBean) query.getSingleResult();
		try {
			entityTransaction.begin();
			double price = orderBean.getTotalBill();
			double discount = couponBean.getDiscount();
			newPrice = price - (price * (discount / 100));
			System.err.println(newPrice);
			count = couponBean.getCount() - 1;
			couponBean.setOriginalBill(newPrice);
			couponBean.setCount(count);
			updateCoupon(couponBean);
			orderBean.setTotalBill(newPrice);
			entityManager.persist(orderBean);
			isApplied = true;
			entityTransaction.commit();
		} catch (Exception e) {
			throw new CapstoreException("No coupon is get applied");
		}
		return isApplied;

	}

	@Override
	public OrderDetailsBean invoiceGenerator(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		OrderDetailsBean orderDetailsBean =  null;
		try {
			String jpql = "FROM OrderDetailsBean WHERE email=: email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			orderDetailsBean = (OrderDetailsBean) query.getSingleResult();
		} catch (Exception e) {
			throw new CapstoreException("No coupon is get applied");
		}
		return orderDetailsBean;
	}
}
