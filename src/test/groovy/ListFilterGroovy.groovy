import com.aor.numbers.DivisibleByFilter
import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class ListFilterGroovy extends Specification{
    def "positives"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filterer = new ListFilterer(new PositiveFilter())

        when:
        def result = filterer.filter(list)

        then:
        result == Arrays.asList(2,4,5)
    }

    def "divisible"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filterer = new ListFilterer(new DivisibleByFilter(2))

        when:
        def result = filterer.filter(list)

        then:
        result == Arrays.asList(2,4,-2)
    }


    def "filterer test true"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filter_mock = Mock(GenericListFilter)
        filter_mock.accept(_) >> true
        def filterer = new ListFilterer(filter_mock)

        when:
        def result = filterer.filter(list)

        then:
        result == list
    }

    def "filterer test false"(){
        given:
        def list = Arrays.asList(-1,2,4,-2,5)
        def filter_mock = Mock(GenericListFilter)
        filter_mock.accept(_) >> false
        def filterer = new ListFilterer(filter_mock)

        when:
        def result = filterer.filter(list)

        then:
        result == Arrays.asList()
    }
}
