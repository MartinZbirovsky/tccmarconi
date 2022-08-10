import java.util.List;
import java.util.stream.Collectors;

public interface ResultHandlerF {
    void resultProcess ();
    void resultProcess (String aFilePath);
    void resultProcess (String aFirstFilePath, String aSecondFilePath);
    default List<Integer> filterNumber(List<Integer> aNums) {
        return (aNums.size() % 2 == 0)
                ? aNums.stream().filter(n -> n%2 == 0).collect(Collectors.toList())
                : aNums.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
    }
}
