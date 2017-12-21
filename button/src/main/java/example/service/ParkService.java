package example.service;


import example.entity.Park;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkService {


    List <Park> getList();



}
