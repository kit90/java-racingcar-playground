package racingFeedback;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name.trim();
    }

    private static void validateNameLength(String name) {
        if(StringUtils.isBlank(name)) {
            throw new RuntimeException("자동차 이름은 비어있을 수 없습니다.");
        }
        if(name.length() > MAX_NAME_LENGTH) {
            String sizeErrorMsg = String.format("자동차 이름은 %d자 이하여야합니다.", MAX_NAME_LENGTH);
            throw  new RuntimeException(sizeErrorMsg);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
