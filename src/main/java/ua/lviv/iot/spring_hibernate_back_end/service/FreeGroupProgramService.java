package ua.lviv.iot.spring_hibernate_back_end.service;

import ua.lviv.iot.spring_hibernate_back_end.dto.FreeGroupProgramDto;

public interface FreeGroupProgramService extends GeneralService<FreeGroupProgramDto, Integer>{
    void insert10recordsIntoTable();
}

