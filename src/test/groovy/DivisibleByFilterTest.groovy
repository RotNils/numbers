import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisibleByFilterTest extends Specification{


    def 'dividable by 2'() {
        given:
        def filter = new DivisibleByFilter(2)
        when:
        def list = Arrays.asList(0,2,66,88,1000)
        then:
        list.every {x -> filter.accept(x)}
    }

    def 'not dividable by 2'() {
        given:
        def filter = new DivisibleByFilter(2)
        when:
        def list = Arrays.asList(7,3,67,89,1001)
        then:
        list.every {x -> !filter.accept(x)}
    }

}
