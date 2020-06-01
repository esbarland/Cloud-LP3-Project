<?php

require 'vendor/autoload.php';

use GuzzleHttp\Client;
use GuzzleHttp\EntityBody;

$clientGAE = new Client([
	'base_uri' => 'http://inf63app3-276717.appspot.com'
]);
$clientHeroku = new Client([
	'base_uri' => 'http://cloud-project-lp.herokuapp.com'
]);

echo "<h2>Client Guzzle</h2>";

// Tests des comptes
//listAccounts($clientGAE);
//createAccount($clientGAE, "Pierre", "Paul", 366, "low");
//deleteAccount($clientGAE, 5662792157757440);

// Tests des réponses
//listApproval($clientGAE);
//createApproval($clientGAE, 5700228501995520, "accepted");
//deleteApproval($clientGAE, 5677459739508736);

// Test de vérification d'un compte
//checkAccount($clientGAE, 5700228501995520);

// Test pour Créditer un compte
//loanApproval($clientHeroku, 5700228501995520, 54);

################################################################################

// Lister les comptes
function listAccounts(Client $client){
	$response = $client->get('/account');
	echo "liste des comptes: <br>";
	$tab = json_decode($response->getBody(), true);

	foreach ($tab as $value) {
		echo "- " . $value["nom"] . " " . $value["prenom"] . " " . $value["amount"] . " " . $value["risk"] . " " . $value["id"] . "<br>";
	}
}

// Créer un compte
function createAccount(Client $client, String $nom, String $prenom, int $amount, String $risk){
	$response= $client->post('/account/' . $nom . '/' . $prenom . '/' . $amount . '/' . $risk);
	echo "Compte crée: <br>" . $response->getBody() . "<br>";
}

// Supprimer un compte
function deleteAccount(Client $client, int $id){
	$response= $client->delete('/account/' . $id);
	echo "Compte supprimé: <br>" . $response->getBody() . "<br>";
}

################################################################################

// Lister les réponses
function listApproval(Client $client){
	$response = $client->get('/approval');
	echo "liste des réponses: <br>";
	$tab = json_decode($response->getBody(), true);

	foreach ($tab as $value) {
		echo "- " . $value["idAccount"] . " " . $value["reponse"] . " " . $value["id"] . "<br>";
	}
}

// Créer une réponse
function createApproval(Client $client, int $idAccount, String $reponse){
	$response= $client->post('/approval/' . $idAccount . '/' . $reponse);
	echo "Réponse créée: <br>" . $response->getBody() . "<br>";
}

// Supprimer une réponse
function deleteApproval(Client $client, int $id){
	$response= $client->delete('/approval/' . $id);
	echo "Réponse supprimée: <br>" . $response->getBody() . "<br>";
}

################################################################################

// Vérifier le risque d'un compte
function checkAccount(Client $client, int $id){
	$response= $client->get('/check/' . $id);
	echo "Vérification d'un compte : <br>" . $response->getBody() . "<br>";
}

################################################################################

// Créditer un compte
function loanApproval(Client $client, int $id, int $amount){
	$response= $client->get('/loanapproval/' . $id . '/' . $amount);
	echo "Créditer un compte : <br>" . $response->getBody() . "<br>";
}

?>