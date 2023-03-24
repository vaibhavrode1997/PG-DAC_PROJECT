package com.demo.EventManagementPortal.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.EventManagementPortal.beans.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback,Integer>
{

}
