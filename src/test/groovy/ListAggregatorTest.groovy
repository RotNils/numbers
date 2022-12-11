import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListAggregatorTest extends Specification{
    private def list

    def setup() {
        list = Arrays.asList(1,2,4,2,5)
    }

    def 'sum test'() {
        given:
        def aggregator = new ListAggregator()
        when:
        def sum = aggregator.sum(list)
        then:
        sum == 14
    }

    def 'max test'() {
        given:
        def aggregator = new ListAggregator()
        when:
        def max = aggregator.max(list)
        then:
        max == 5
    }

    def 'min test'() {
        given:
        def aggregator = new ListAggregator()
        when:
        def min = aggregator.min(list)
        then:
        min == 1
    }

    def 'distinct testing'() {
        given:
        def aggregator = new ListAggregator()
        def deduplicator = new ListDeduplicator(new ListSorter())
        when:
        def count = aggregator.distinct(list, deduplicator)
        then:
        count == 4
    }

    def 'Testing max bug 7263'() {
        given:
        def aggregator = new ListAggregator()
        when:
        def max = aggregator.max(Arrays.asList(-1, -4, -5))
        then:
        max == -1
    }

    def 'testing distinct bug 8726'() {
        given:
        def deduplicator = Mock(GenericListDeduplicator.class)
        def aggregator = new ListAggregator()
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        when:
        def distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator)
        System.out.println(distinct)
        then:
        distinct == 3
    }

}
