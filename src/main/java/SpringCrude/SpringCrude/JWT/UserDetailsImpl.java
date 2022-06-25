package SpringCrude.SpringCrude.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SpringCrude.SpringCrude.Repository.StudentRepository;
@Service
public class UserDetailsImpl implements UserDetailsService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findByEmail(username).orElseThrow(null);
	}

	
}
