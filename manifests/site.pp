
node 'puppetagent' {
  include role::webserver
  include jenkins
}
class {'jenkins':
  executors => 0,
}

jenkins::job { 'test-build-job':
  config => template("${templates}/test-build-job.xml.erb"),
}
jenkins::plugin{ 'git': }
class { 'src': }
