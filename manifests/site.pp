node 'puppetagent' {
  include role::webserver
  include jenkins
}
class {'jenkins':
  executors => 0,
}

jenkins::plugin{ 'git': }
