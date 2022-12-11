import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterTest extends Specification{

    def 'Testing: accept'() {
        given:
        def positives = Arrays.asList(1,65,654,6542,Integer.MAX_VALUE)
        def notPositives = Arrays.asList(-1,-65,-654,-6542,Integer.MIN_VALUE)
        when:
        def filter = new PositiveFilter()
        then:
        positives.every {it ->  filter.accept(it) }
        notPositives.every {it -> !filter.accept(it) }
    }
}
