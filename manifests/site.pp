node 'puppetagent' {
  include role::webserver
  include jenkins
}

jenkins::plugin{ 'git': }
