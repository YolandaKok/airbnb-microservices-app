package com.yolanda.kokkinou.airbnbservice;

import com.yolanda.kokkinou.airbnbservice.entities.Review;
import com.yolanda.kokkinou.airbnbservice.entities.Unit;
import com.yolanda.kokkinou.airbnbservice.repositories.UnitRepository;
import com.yolanda.kokkinou.airbnbservice.services.impl.UnitServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UnitServiceTest {
    @InjectMocks
    private UnitServiceImpl unitService;

    @Mock
    private UnitRepository unitRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnAllUnits() {
        List<Unit> units = new ArrayList<>();

        Set<Review> reviewSet1 = null;
        Set<Review> reviewSet2 = null;

        units.add(new Unit(1L, "Great house", "Loft", "MODERATE", 4, null, "Athens", reviewSet1));
        when(unitRepository.findAll()).thenReturn((units));

        List<Unit> unitResults = unitService.getAllUnits();
        assertEquals(unitResults, units);
    }

    @Test
    public void shouldReturnAllUnitsPage() {
        List<Unit> units = new ArrayList<>();

        Set<Review> reviewSet1 = null;
        Set<Review> reviewSet2 = null;

        units.add(new Unit(1L, "Great house", "Loft", "MODERATE", 4, null, "Athens", reviewSet1));
        units.add(new Unit(2L, "Great house", "Loft", "MODERATE", 3, null, "Lefkada", reviewSet2));

        Page<Unit> page = new PageImpl<>(units);

        PageRequest pageRequest = PageRequest.of(0, 2);

        Mockito.when(unitRepository.findAll(pageRequest)).thenReturn(page);

        Page<Unit> list = unitService.getAllUnits(pageRequest);
        List<Unit> content = list.getContent();

        assertEquals(units, content);
    }
}
