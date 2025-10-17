package com.tekpyramid.DoctorFlow.Service;

import com.tekpyramid.DoctorFlow.Dto.UserLoginDTO;
import com.tekpyramid.DoctorFlow.Dto.UserSignUpDTO;
import com.tekpyramid.DoctorFlow.Entity.Doctor;
import com.tekpyramid.DoctorFlow.Entity.Role;
import com.tekpyramid.DoctorFlow.Entity.User;
import com.tekpyramid.DoctorFlow.Repository.RoleRepository;
import com.tekpyramid.DoctorFlow.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

    @Override
    public String signUpUser(UserSignUpDTO userSignUpDTO) {

        Optional<User> userExist= userRepository.findByEmail(userSignUpDTO.getEmail());

        if(userExist.isPresent()){
            throw new RuntimeException("User details exists with this email:" + userSignUpDTO.getEmail());
        }

        User user = new User();
        BeanUtils.copyProperties(userSignUpDTO,user);

        Role userRole = roleRepository.findByRoleName("user");
        user.setRole(userRole);


       userRepository.save(user);

        return "User SignUp done Successfully";

    }

    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {

        Optional<User>userEmailExist = userRepository.findByEmail(userLoginDTO.getEmail());

        if(userEmailExist.isEmpty()){
            throw new RuntimeException("User not found with this email:"+userLoginDTO.getEmail());
        }

        User user = userEmailExist.get();

        if(!user.getPassword().equals(userLoginDTO.getPassword())){
            throw new RuntimeException("Invalid Password");
        }
        return "User Login Successful!!";

    }
}
