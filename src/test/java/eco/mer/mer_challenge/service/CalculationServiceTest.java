package eco.mer.mer_challenge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculationServiceTest {

    private CalculationService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CalculationService();
    }


    @Nested
    class NegativeTests {

        @DisplayName("Empty List 2 Numbers")
        @Test
        void find2NumbersSumEquals2020_1() {

            // GIVEN
            List<Integer> emptyList = Collections.emptyList();
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(emptyList, target, 2)).isEqualTo(BigInteger.ZERO);
        }

        @DisplayName("Null List 2 Numbers")
        @Test
        void find2NumbersSumEquals2020_2() {

            // GIVEN
            List<Integer> emptyList = null;
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(emptyList, target, 2)).isEqualTo(BigInteger.ZERO);
        }

        @DisplayName("Empty List 3 Numbers")
        @Test
        void find3NumbersSumEquals2020_1() {

            // GIVEN
            List<Integer> emptyList = Collections.emptyList();
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(emptyList, target, 3)).isEqualTo(BigInteger.ZERO);
        }

        @DisplayName("Null List 3 Numbers")
        @Test
        void find3NumbersSumEquals2020_2() {

            // GIVEN
            List<Integer> emptyList = null;
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(emptyList, target, 3)).isEqualTo(BigInteger.ZERO);
        }
    }

    @Nested
    class PositiveTests {

        @DisplayName("Example List, correct output - 2 Numbers")
        @Test
        void find2NumbersSumEquals2020_1() {

            // GIVEN
            List<Integer> emptyList = List.of(1721, 979, 366, 299, 675, 1456);
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(emptyList, target, 2)).isEqualTo(BigInteger.valueOf(514579));
        }

        @DisplayName("List with no solution 2 Numbers")
        @Test
        void find2NumbersSumEquals2020_2() {

            // GIVEN
            List<Integer> invalidList = List.of(1654, 300, 543, 156, 100, 1456);
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(invalidList, target, 2)).isEqualTo(BigInteger.ZERO);
        }

        @DisplayName("Example List, correct output - 3 Numbers")
        @Test
        void find3NumbersSumEquals2020_1() {

            // GIVEN
            List<Integer> emptyList = List.of(1721, 979, 366, 299, 675, 1456);
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(emptyList, target, 3)).isEqualTo(BigInteger.valueOf(241861950));
        }

        @DisplayName("List with no solution 3 Numbers")
        @Test
        void find3NumbersSumEquals2020_2() {

            // GIVEN
            List<Integer> invalidList = List.of(1654, 300, 543, 156, 100, 1456);
            int target = 2020;

            // WHEN/THEN
            assertThat(underTest.findNNumbersSumEqualsTarget(invalidList, target, 3)).isEqualTo(BigInteger.ZERO);
        }

    }
}
