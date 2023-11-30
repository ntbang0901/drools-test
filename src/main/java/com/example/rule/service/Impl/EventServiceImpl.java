package com.example.rule.service.Impl;

import com.example.rule.repository.EventRepository;
import com.example.rule.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

}
