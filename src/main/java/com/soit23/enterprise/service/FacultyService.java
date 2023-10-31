package com.soit23.enterprise.service;

import com.soit23.enterprise.entitiy.Faculty;

import java.util.List;

public interface FacultyService {

    public List<Faculty> findAll();

    public Faculty findById(int theId);

    public void save(Faculty theFaculty);

    public void deleteById(int theId);
}
