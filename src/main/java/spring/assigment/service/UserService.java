package spring.assigment.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import spring.assigment.dto.UserDto;
import spring.assigment.model.User;
import spring.assigment.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto addUserDetails(UserDto userDto) {
        User user = convertToEntity(userDto);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    public UserDto updateUserDetails(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        updateUserFromDto(user, userDto);
        User updatedUser = userRepository.save(user);
        return convertToDto(updatedUser);
    }


    public void deleteUserDetails(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto getUserDetails(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDto(user);
    }


    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setMobile(userDto.getMobile());
        user.setAddress(userDto.getAddress());
        return user;
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setMobile(user.getMobile());
        userDto.setAddress(user.getAddress());
        return userDto;
    }


    private void updateUserFromDto(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setMobile(userDto.getMobile());
        user.setAddress(userDto.getAddress());
    }





}
