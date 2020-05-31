<?php

require 'vendor/autoload.php';

use GuzzleHttp\Client;

use GuzzleHttp\EntityBody;

$client = new Client([
	'base_uri' => 'http://inf63app3-276717.appspot.com'
]);

getAccounts($client);

//$response= $client->post('/account/toto/titi/36');

echo "<br><br><br>";

function getAccounts($client){
	$response = $client->get('/account');
	echo "liste des comptes: <br>";
	$tab = json_decode($response->getBody(), true);

	foreach ($tab as $value) {
		echo "- " . $value["nom"] . " " . $value["prenom"] . " " . $value["amount"] . " " . $value["risk"] . "<br>";
	}
}

?>