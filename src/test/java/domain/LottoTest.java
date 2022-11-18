package domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 각 숫자의 범위가 1부터 45까지인지 비교")
    @Test
    void validateLottoNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 45, 56, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 로또 번호 중 중복 여부가 있는지 검증")
    @Test
    void validateLottoDuplication() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}