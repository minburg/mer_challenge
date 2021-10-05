package eco.mer.mer_challenge.service;

import eco.mer.mer_challenge.json.InputFileMappingObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UniqueNumberServiceTest {

    @InjectMocks
    private UniqueNumberService underTest;

    @Mock
    private FileReaderService fileReaderService;

    @Value("classpath:mer_unc_input.json")
    Resource resourceFile;

    @BeforeEach
    void setUp() {
        underTest = new UniqueNumberService(fileReaderService);
        MockitoAnnotations.openMocks(underTest);
    }


    @Nested
    class NegativeTests {

        @DisplayName("Unique Number Test wrong input")
        @ParameterizedTest()
        @ValueSource(ints = {-100, 0, 11, 1000, 24954, Integer.MAX_VALUE})
        void getUniqueNumber_1() {

            // WHEN/THEN
            ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class, () -> underTest.getUniqueNumber(0));
            assertThat(responseStatusException).isNotNull();
            assertThat(responseStatusException.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
            Mockito.verify(fileReaderService, Mockito.never()).readFromResourceFile();
        }
    }


    @Nested
    class PositiveTests {

        @DisplayName("Unique Number correct input")
        @Test
        void getUniqueNumber_1() {

            InputFileMappingObject input = InputFileMappingObject.builder().inputNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)).build();
            Mockito.when(fileReaderService.readFromResourceFile()).thenReturn(input);

            // WHEN/THEN
            assertThat(underTest.getUniqueNumber(2)).isNotNull();
            Mockito.verify(fileReaderService).readFromResourceFile();
        }
    }
}
