logLevel := Level.Warn

resolvers += Resolver.typesafeRepo("releases")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")
addSbtPlugin("com.lightbend.sbt" % "sbt-java-formatter" % "0.2.0")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")
