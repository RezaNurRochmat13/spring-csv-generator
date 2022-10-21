package com.spring.generator.CSV.service;

import com.spring.generator.CSV.entity.User;
import com.spring.generator.CSV.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> doGetAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User doCreateUsers(User payload) {
        return userRepository.save(payload);
    }

    @Override
    public void doGenerateReportUser(Writer writer) throws IOException {
        List<User> users = userRepository.findAll();

        try {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("id", "username", "address", "city"));

            for(User user: users) {
                csvPrinter.printRecord(user.getId(), user.getUserName(),
                        user.getAddress(), user.getCity());
            }

        } catch (Exception exception) {
            log.error("Error when writing csv file :", exception);
            throw exception;
        }
    }
}
