# Спец-предложение
### Модель
```json
  {
                        "name": "offerId",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "firebaseOfferId",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "userId",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "activities",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "imageUrls",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "offerDetails",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "discount",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "discount_pro",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "viewsCount",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "isActive",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "isVerified",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessName",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessId",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessPhone",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessType",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessSport",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessPublicMail",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessWorkMail",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessUrl",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessLat",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "businessLon",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "spotId",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "spotName",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "spotLat",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "spotLon",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "created",
                        "type": "SEMANTIC"
                    },
                    {
                        "name": "updated",
                        "type": "SEMANTIC"
                    }
```


### Создать спец-предложение

```
https://offers-dev.navat.pro/api/offer
```
На входе
```
POST
Content-Type: application/json
```
```json
{
    "activities": [],
    "businessId": null,
    "businessLat": -26.149969,
    "businessLon": 28.135732,
    "businessName": "Orca Dive & Leisure",
    "businessPhone": "+27114545640",
    "businessPublicMail": "info@orca.co.za, mail-iconinfo@orca.co.za",
    "businessSport": [
        "FREEDIVING",
        "SCUBADIVING"
    ],
    "businessType": [
        "SCHOOL",
        "SHOP",
        "SERVICES"
    ],
    "businessUrl": "orca.co.za",
    "businessWorkMail": null,
    "created": null,
    "discount": null,
    "discount_pro": null,
    "firebaseOfferId": null,
    "imageUrls": [
        "http://static.navat.pro/City of Johannesburg.Orca Dive & Leisure.png"
    ],
    "isActive": true,
    "isVerified": true,
    "offerDetails": "Course offerings include beginner to professional level instruction in Scuba, Spearfishing, Freediving (apnea) & Underwater Hockey. Our instructors and presenters are respected and experienced professionals who strive to provide not only instruction but also encouragement and passion.\r\n",
    "offerId": 49057,
    "spotId": -1,
    "spotLat": null,
    "spotLon": null,
    "spotName": "City of Johannesburg",
    "updated": null,
    "userId": "UserNullID",
    "viewsCount": null
}
```
HTTP/1.1 201
Location: http://localhost:8080/api/offer/49060
И созданный объект
```json
{
    "activities": [
        "16"
    ],
    "businessId": "d2257ff5cdcd7b0f",
    "businessLat": 45.03756358220917,
    "businessLon": 12.224684581160545,
    "businessName": "SURF Elettrico",
    "businessPhone": "3388771737",
    "businessPublicMail": null,
    "businessSport": [],
    "businessType": [],
    "businessUrl": "www.onean.com",
    "businessWorkMail": "sa@navat.ru",
    "created": 1516722777977,
    "discount": 40,
    "discount_pro": 60,
    "firebaseOfferId": "-KqdS0UuBQ7z578R2dCf",
    "imageUrls": [
        "http://www.onean.com/wp-content/uploads/2016/06/logo_onean.png"
    ],
    "isActive": true,
    "isVerified": false,
    "offerDetails": "speciale offerta per i surfisti",
    "offerId": 49058,
    "spotId": -1,
    "spotLat": 45.03756358220917,
    "spotLon": 12.224684581160545,
    "spotName": "Porto Viro",
    "updated": 1516722777977,
    "userId": "123",
    "viewsCount": 0
}
```
Апдейт счетчика просмотров

```http request
POST /updateCount/{offerId}
```
На входе ничего

Успех
```http response
HTTP/1.1 200
```
Получить все оферы по userId

```http request
GET /user/{userId}
```
Успех
```json
[
    {
        "activities": [
            "16"
        ],
        "businessId": "d2257ff5cdcd7b0f",
        "businessLat": 45.03756358220917,
        "businessLon": 12.224684581160545,
        "businessName": "SURF Elettrico",
        "businessPhone": "3388771737",
        "businessPublicMail": null,
        "businessSport": [],
        "businessType": [],
        "businessUrl": "www.onean.com",
        "businessWorkMail": "sa@navat.ru",
        "created": 1516711978000,
        "discount": 40,
        "discount_pro": 60,
        "firebaseOfferId": "-KqdS0UuBQ7z578R2dCf",
        "imageUrls": [
            "http://www.onean.com/wp-content/uploads/2016/06/logo_onean.png"
        ],
        "isActive": true,
        "isVerified": false,
        "offerDetails": "speciale offerta per i surfisti",
        "offerId": 49058,
        "spotId": -1,
        "spotLat": 45.03756358220917,
        "spotLon": 12.224684581160545,
        "spotName": "Porto Viro",
        "updated": 1516711978000,
        "userId": "123",
        "viewsCount": 0
    },
    {
        "activities": [
            "16"
        ],
        "businessId": "d2257ff5cdcd7b0f",
        "businessLat": 45.03756358220917,
        "businessLon": 12.224684581160545,
        "businessName": "SURF Elettrico",
        "businessPhone": "3388771737",
        "businessPublicMail": null,
        "businessSport": [],
        "businessType": [],
        "businessUrl": "www.onean.com",
        "businessWorkMail": "sa@navat.ru",
        "created": 1516723526000,
        "discount": 40,
        "discount_pro": 60,
        "firebaseOfferId": "-KqdS0UuBQ7z578R2dCf",
        "imageUrls": [
            "http://www.onean.com/wp-content/uploads/2016/06/logo_onean.png"
        ],
        "isActive": true,
        "isVerified": false,
        "offerDetails": "speciale offerta per i surfisti",
        "offerId": 49059,
        "spotId": -1,
        "spotLat": 45.03756358220917,
        "spotLon": 12.224684581160545,
        "spotName": "Porto Viro",
        "updated": 1516723526000,
        "userId": "123",
        "viewsCount": 0
    },
    {
        "activities": [
            "16"
        ],
        "businessId": "d2257ff5cdcd7b0f",
        "businessLat": 45.03756358220917,
        "businessLon": 12.224684581160545,
        "businessName": "SURF Elettrico",
        "businessPhone": "3388771737",
        "businessPublicMail": null,
        "businessSport": [],
        "businessType": [],
        "businessUrl": "www.onean.com",
        "businessWorkMail": "sa@navat.ru",
        "created": 1516723624000,
        "discount": 40,
        "discount_pro": 60,
        "firebaseOfferId": "-KqdS0UuBQ7z578R2dCf",
        "imageUrls": [
            "http://www.onean.com/wp-content/uploads/2016/06/logo_onean.png"
        ],
        "isActive": true,
        "isVerified": false,
        "offerDetails": "speciale offerta per i surfisti",
        "offerId": 49060,
        "spotId": -1,
        "spotLat": 45.03756358220917,
        "spotLon": 12.224684581160545,
        "spotName": "Porto Viro",
        "updated": 1516723864000,
        "userId": "123",
        "viewsCount": 2
    }
]
```
Получить список офферов по координатам и фильтрация
```http request
GET /q?lat=61.2548&lon=73.5698&radius=50
GET /q?lat=61.2548&lon=73.5698&radius=50&page=0&size=10
GET /q?lat=61.2548&lon=73.5698&radius=50&businessTypes=SERVICES&businessSports=YACHTING&page=0&size=10
```
Где
```
businessTypes значение из списка:

     ACCOMMODATION,
      CLUB,
      MEAL,
      RENT,
      SERVICES,
      SHOP,
      STORAGE,
      SCHOOL,
      TRIP

 businessSports значение из списка:
        BOAT,
        CATAMARAN,
        FISHING,
        FLYBOARD,
        FREEDIVING,
        JETBOARD,
        JETSKI,
        JETSURF,
        JETPACK,
        KAYAK,
        KITE,
        PARAGLIDING,
        SANDKITE,
        SCUBADIVING,
        SNOWKITE,
        SUP,
        SURF,
        WAKESURF,
        WAKEBOARD,
        WINDSURF,
        YACHTING
```
Результат
```
HTTP/1.1 200
```
```json
{
    "content": [
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.280647,
            "businessLon": -85.637714,
            "businessName": "Miller Marine Yacht Service Inc",
            "businessPhone": "+1850-265-6768",
            "businessPublicMail": "info@millermarineyachts.com",
            "businessSport": [
                "YACHTING",
                "BOAT"
            ],
            "businessType": [
                "SERVICES",
                "SHOP"
            ],
            "businessUrl": "http://www.millermarineyachts.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Miller Marine Yacht Service.jpg"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "Located in the heart of the panhandle, this full service marine facility and custom boat builder is here to meet all your needs. As a family owned business we strive to achieve the highest level of customer satisfaction. Miller Marine employs the most experienced and highly trained professionals in the area to provide quality work at competitive prices. We also offer an onsite prop shop and Ship Store. ",
            "offerId": 42893,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.182454,
            "businessLon": -85.649614,
            "businessName": "Gulf Marine",
            "businessPhone": "+1850215-7500",
            "businessPublicMail": "gulf1@knology.net",
            "businessSport": [
                "BOAT",
                "YACHTING",
                "CATAMARAN"
            ],
            "businessType": [
                "SERVICES",
                "SHOP"
            ],
            "businessUrl": "http://www.gulfmarineinc.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Gulf Marine.png"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "The experienced service department at Gulf Marine enjoys rigging, repairing and maintaining boats of all types. As an factory authorized, 5-star certified marine service center, we can maintain, repair or replace your marine products with ease. We also offer winter service specials and other timely promotions, so be sure to contact us for your marine service needs. Gulf Marine is Panama City's factory-authorized service center for the best products on the water.",
            "offerId": 42739,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.145862,
            "businessLon": -85.628155,
            "businessName": "Bay County Boatyard Inc",
            "businessPhone": "+1850-215-9283",
            "businessPublicMail": "",
            "businessSport": [
                "YACHTING",
                "BOAT",
                "CATAMARAN"
            ],
            "businessType": [
                "SERVICES",
                "STORAGE"
            ],
            "businessUrl": "http://baycountyboatyard.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Bay County Boatyard.png"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "Located just East of downtown Panama City on beautiful Watson Bayou, 1 mile off the Inter Coastal Waterway. We service all types of boats, sail, power and commercial. Whether it?s regular maintenance, repairs or a major refit, you can be confident that all work is completed on time, in a professional manner and at a reasonable price.",
            "offerId": 42704,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.121091,
            "businessLon": -85.595164,
            "businessName": "Hideaway Haven Yacht Club",
            "businessPhone": "+1850-215-4078",
            "businessPublicMail": "info@hideawayhavenmarinapcfl.com",
            "businessSport": [
                "YACHTING"
            ],
            "businessType": [
                "CLUB",
                "RENT",
                "SERVICES"
            ],
            "businessUrl": "http://hideawayhavenmarinapcfl.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Hideaway Haven Yacht Club.svg"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "A marina and yacht club located on Pitts Bayou in Panama City, Florida.",
            "offerId": 42743,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.152847,
            "businessLon": -85.658967,
            "businessName": "Stem to Stern Sailing LLC",
            "businessPhone": "+1850-866-8724",
            "businessPublicMail": "stemtosternsailing@gmail.com",
            "businessSport": [
                "YACHTING",
                "BOAT"
            ],
            "businessType": [
                "SCHOOL",
                "TRIP",
                "SERVICES"
            ],
            "businessUrl": "http://stemtosternsailing.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.stem to stern.jpg"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "Sailing Lessons & Charters * Boat Service & Retai",
            "offerId": 42926,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.159058,
            "businessLon": -85.735437,
            "businessName": "Gulf Coast Marine Service, Inc.",
            "businessPhone": "+1850-258-4423",
            "businessPublicMail": "gcmsinc@comcast.net",
            "businessSport": [
                "BOAT",
                "YACHTING"
            ],
            "businessType": [
                "SERVICES"
            ],
            "businessUrl": "http://www.gulfcoastmarineservice.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Gulf Coast Marine Service Inc.jpg"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "Our goal is to provide reasonable and reliable service to keep you on the water safe and happy with your investment.",
            "offerId": 42738,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.143218,
            "businessLon": -85.727741,
            "businessName": "Bay Point Marina Co",
            "businessPhone": "+1850-235-6911",
            "businessPublicMail": "daniel@baypointmarina.net",
            "businessSport": [
                "BOAT",
                "YACHTING",
                "FISHING",
                "FREEDIVING"
            ],
            "businessType": [
                "RENT",
                "STORAGE",
                "SERVICES",
                "TRIP",
                "MEAL"
            ],
            "businessUrl": "http://www.baypointmarina.net/",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Bay Point Marina Co.jpg"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "A boater's paradise, Bay Point Marina is gently tucked away along the Grand Lagoon in Panama City Beach, Florida, yet conveniently located just five minutes from the beautiful Gulf of Mexico and 15 minutes from the Intracoastal Waterway. The location, the amenities, the people all set Bay Point apart as one of the best marinas in Northwest Florida. ",
            "offerId": 42705,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.195833,
            "businessLon": -85.755453,
            "businessName": "Harbourage Yacht Club",
            "businessPhone": "+1850-867-3037",
            "businessPublicMail": "info@hycmarina.com",
            "businessSport": [
                "YACHTING",
                "BOAT"
            ],
            "businessType": [
                "CLUB",
                "STORAGE",
                "SERVICES"
            ],
            "businessUrl": "http://hycmarina.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Harbourage Yacht Club.png"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "The Harbourage Yacht Club is a premier Marina located in Panama City Beach, Fl. Boasting a total of 64 slips, and being located in a gated community, this Marina is the perfect location to keep your Boat or Yacht. So if you are a Panama City Beach resident, or maybe just a Seasonal visitor, consider The Harbourage Yacht Club for your Watercraft.",
            "offerId": 42742,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.145156,
            "businessLon": -85.748918,
            "businessName": "MarineMax Panama City Beach",
            "businessPhone": "+1850-708-1317",
            "businessPublicMail": "caleb.peavler@marinemax.com",
            "businessSport": [
                "BOAT",
                "YACHTING",
                "CATAMARAN"
            ],
            "businessType": [
                "SCHOOL",
                "SERVICES",
                "SHOP",
                "TRIP",
                "RENT"
            ],
            "businessUrl": "https://www.marinemax.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.MarineMax Panama City Beach.png"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "The nation's largest recreational boat & yacht retailer",
            "offerId": 42890,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        },
        {
            "activities": [],
            "businessId": null,
            "businessLat": 30.141381,
            "businessLon": -85.748969,
            "businessName": "Legendary Marine - Panama City Beach",
            "businessPhone": "+1850-271-8950",
            "businessPublicMail": "mailinglist@legendarymarine.com",
            "businessSport": [
                "BOAT",
                "YACHTING",
                "CATAMARAN"
            ],
            "businessType": [
                "SERVICES",
                "SHOP"
            ],
            "businessUrl": "https://www.legendarymarine.com",
            "businessWorkMail": null,
            "created": null,
            "discount": null,
            "discount_pro": null,
            "firebaseOfferId": null,
            "imageUrls": [
                "http://static.navat.pro/bay county.Legendary Marine.jpg"
            ],
            "isActive": true,
            "isVerified": true,
            "offerDetails": "The Gulf Coast's Largest Boat Dealer - #1 in Sales and Service",
            "offerId": 42889,
            "spotId": -1,
            "spotLat": null,
            "spotLon": null,
            "spotName": "Bay County",
            "updated": null,
            "userId": "UserNullID",
            "viewsCount": null
        }
    ],
    "first": true,
    "last": false,
    "number": 0,
    "numberOfElements": 10,
    "size": 10,
    "sort": null,
    "totalElements": 11,
    "totalPages": 2
}
```
