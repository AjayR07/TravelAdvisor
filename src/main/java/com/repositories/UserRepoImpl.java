package com.repositories;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.User;
@Repository
@Transactional
public class UserRepoImpl implements UserRepo {
	@Autowired
	private SessionFactory factory;



	private Session getSession() {
		return factory.getCurrentSession();
	}
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public User findbyuname(String uname) {
		System.out.println(1);
		System.out.println("uname "+uname);
		Criteria cr = factory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("Mail",uname));
		List results = cr.list();
		System.out.println("name "+results);
		Object query=results.get(0);
		System.out.println("name "+query);
		System.out.println("name333333 "+((User)query).getUsername());
		return (User)query;
	}
	@Override
	public int save(String uname,String email,String pass,String phno) {
		// TODO Auto-generated method stub
		User u  =new User(); 		
		Criteria cr = factory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("Mail",email));
		List results = cr.list();

		boolean ans = results.isEmpty();
		if (ans == true)

		{
			u.setUsername(uname);
			u.setRole("USER");
			u.setFlag(0);
			u.setMail(email);
			u.setPhonenum((phno));
			String generatedSecuredPasswordHash = BCrypt.hashpw(pass, BCrypt.gensalt(8));
			System.out.println(generatedSecuredPasswordHash);
			u.setPassword(generatedSecuredPasswordHash);
			factory.getCurrentSession().save(u);
			System.out.println("saved");
			return 1;
		}
		System.out.println("not saved");
		return 0;


	}


}
