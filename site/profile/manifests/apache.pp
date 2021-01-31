class profile::apache {
   class {'::apache':
	serveradmin => 'u2004643@uel.ac.uk',
    }
	apache::vhost { 'vhost.example.com':
	   port => '80',
	   docroot => '/var/www/vhost',
	}
}
