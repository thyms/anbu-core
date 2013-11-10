package anbu.spec

enum Path {
  BASE(BaseSpecification.config.core.baseContext)

  String path

  Path(String path){
    this.path = path
  }

  @Override
  String toString() {
    this.path
  }
}
