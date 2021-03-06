#Open Médicaments
Open Médicaments est un moteur de recherche permettant d'accéder à l'ensemble des données et documents de référence sur les médicaments commercialisés ou ayant été commercialisés durant les trois dernières années en France. Disponible sur  [open-medicaments.fr](http://open-medicaments.fr) *** Deprecated : Plus accéssible

Open Médicaments s'appuie les données OpenData fournies par la [base de données publique des médicaments](http://base-donnees-publique.medicaments.gouv.fr/index.php).

<img src="https://github.com/Ellixo/MedicamentDB/blob/master/doc/screenshot-home.png" alt="Open Médicaments" width="700px"/>

##Fonctionnalités
###Recherche médicaments
<img src="https://github.com/Ellixo/MedicamentDB/blob/master/doc/screenshot-recherche.png" alt="Recherche médicaments" width="700px"/>

###Fiche médicament
<img src="https://github.com/Ellixo/MedicamentDB/blob/master/doc/screenshot-fiche.png" alt="Fiche médicament" width="700px"/>

##API
*En complément du moteur de recherche open-medicaments.fr, une API est founie afin de permettre une intégration des fonctionnalités de recherche et d'affichage des données médicaments.*

*Interface Swagger disponible sur [open-medicaments.fr/swagger](http://open-medicaments.fr/swagger-ui.html)*

#### service permettant de requêter la base de médicaments
```
GET /api/v1/medicaments
```

##### Paramètres
|Type|Name|Description|Obligatoire|
|----|----|----|----|
|Paramètre|query|requête|non|
|Paramètre|page|numéro de page|non|
|Paramètre|limit|nombre maximum de résultats par page|non|

#### service permettant de lire l'ensemble des informations concernant un médicament
```
GET /api/v1/medicaments/{id}
```

##### Paramètres
|Type|Name|Description|Obligatoire|
|----|----|----|----|
|URL|id|code CIS du médicament|oui|

#### service renvoyant les infos base de données (ie. date de mise à jour)
```
GET /api/v1/medicaments/info
```
#### service permettant de vérifier l'état du serveur
```
GET /api/v1/health
```

##Fiche Technique
- Spring Boot 1.3.0
- Angular.js 1.X.X
- Elasticsearch 1.5.2
- Amazon EC2
