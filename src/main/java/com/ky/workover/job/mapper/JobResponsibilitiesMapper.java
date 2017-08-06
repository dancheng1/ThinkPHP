package com.ky.workover.job.mapper;

import com.ky.workover.job.model.JobResponsibilities;

import java.util.List;

public interface JobResponsibilitiesMapper {;

    int deleteByPrimaryKey(Integer positionId);

    int insert(JobResponsibilities record);

    int insertSelective(JobResponsibilities record);

    JobResponsibilities selectByPrimaryKey(Integer positionId);

    int updateByPrimaryKeySelective(JobResponsibilities record);

    int updateByPrimaryKey(JobResponsibilities record);

    List<JobResponsibilities> findJobResponsibilitiesList();
}