node 'puppetagent' {
  include role::webserver
 
  class { 'src': }
}

