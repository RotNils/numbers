import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import spock.lang.Specification

class ListFilterTest extends Specification{
    def 'filter test'() {
        given:
        def filter = Mock(GenericListFilter.class)
        filter.accept(1) >> true
        filter.accept(2) >> true
        filter.accept(3) >> false
        filter.accept(4) >> false
        filter.accept(5) >> true
        filter.accept(6) >> true
        when:
        def filterer = new ListFilterer(filter)
        then:
        Arrays.asList(1, 2, 5, 6) == filterer.filter(Arrays.asList(1, 2, 3, 4, 5, 6))
    }
}
