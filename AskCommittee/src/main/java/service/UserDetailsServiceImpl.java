/*
package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dao.LoginUserDao;
import entity.LoginUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private LoginUserDao userDao;
		
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
			
		LoginUser user = userDao.findUser(id);
			
		if(user == null) {
			throw new UsernameNotFoundException("User" + id + "was not found in the detabase");
		}
			
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ID");
		grantList.add(authority);
			
		//パスワードの暗号化
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
		UserDetails userDetails = (UserDetails)new User(User.getUserName(), encoder.encode(user.getPassword()), grantList);
			
		return userDetails;
		}

	}
*/

