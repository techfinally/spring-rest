package com.techfinally.example.controller;

import com.techfinally.example.bean.ResponseData;
import com.techfinally.example.model.Employee;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tech Finally
 */
@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    private static Map<String, Employee> listItem = new HashMap<>();

    static {
        Employee e1 = new Employee();
        e1.setEmpNo("1");
        e1.setEmpName("Truong Duong");
        e1.setEmpMail("truongduong@techfinally.com");
        e1.setEmpPhone("+84.888.987.789");
        listItem.put(e1.getEmpNo(), e1);

        Employee e2 = new Employee();
        e2.setEmpNo("2");
        e2.setEmpName("Minh Nguyen");
        e2.setEmpMail("minhnguyen@techfinally.com");
        e2.setEmpPhone("+84.777.123.123");
        listItem.put(e2.getEmpNo(), e2);
    }

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findByAll() {
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData(listItem);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findById(@PathVariable String id) {
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData(listItem.get(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> create(@RequestBody Employee employee) {
        listItem.put(employee.getEmpNo(), employee);
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData("ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> update(@RequestBody Employee employee) {
        listItem.put(employee.getEmpNo(), employee);
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData("ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> delete(@PathVariable String id) {
        listItem.remove(id);
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData("ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
