package anbu.spec

class ApplicationStatusSpec extends BaseSpecification {

  def "Homepage renders correctly"() {
    when:
      def resp = core.get(path: Path.BASE)

    then:
      resp.status == 200
  }
}
