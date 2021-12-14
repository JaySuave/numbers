import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import spock.lang.Specification
class ListAggregatorGroovy extends Specification{
    def "soma"() {
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def aggregator = new ListAggregator()

        when:
        def sum = aggregator.sum(list)

        then:
        sum == 14
    }

    def "max"() {
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def aggregator = new ListAggregator()

        when:
        def max = aggregator.max(list)

        then:
        max == 5
    }

    def "min"() {
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def aggregator = new ListAggregator()

        when:
        def min = aggregator.min(list)

        then:
        min == 1
    }
    def "distinct_bug"(){
        given:
        def list = Arrays.asList(1,2,4,2,5)
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2,5)) >> Arrays.asList(1, 2, 4,5)
        def aggregator = new ListAggregator()

        when:
        def result = aggregator.distinct(list,deduplicator)

        then:
        result == 4
    }
}

