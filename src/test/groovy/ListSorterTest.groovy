import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterTest extends Specification{
    private def list
    private def expected

    def setup() {
        list = Arrays.asList(3, 2, 6, 1, 4, 5, 7)
        expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
    }

    def 'sort test'() {
        given:
        def sorter = new ListSorter()
        when:
        def sorted = sorter.sort(list)
        then:
        sorted == expected
    }

    def 'Testing deduplicate bug 8726'() {
        given:
        def sorter = new ListSorter()
        when:
        def sorted = sorter.sort(Arrays.asList(1, 2, 4, 2))
        then:
        sorted == Arrays.asList(1, 2, 2, 4)
    }
}
