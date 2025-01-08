# AL Carbon Calculator

## Description

The AL Carbon Calculator is an API developed in Java with Spring Boot and MongoDB to calculate a user's carbon footprint. The application allows users to register their basic information, provide consumption habits, and receive a detailed calculation of their carbon emissions. This project focuses on best practices, clean code organization, and leveraging modern technologies.

### [POST] /calculator

Initializes a specific carbon footprint calculation for a user.
Input: All required parameters for the calculation must be provided, including:
Name: The user's full name.
Email: A valid email address.
Phone Number: The user's contact phone number.
State/UF: The state where the user resides.
Each calculation is uniquely identified with a generated ID, allowing users to manage and retrieve calculations independently.
Output: Returns a unique calculation ID (calculationId) to be used in subsequent endpoints.
This allows the system to manage multiple calculations for the same or different users seamlessly.

### [PUT] /calculator/update

Updates or overwrites the calculation data for a specific calculation ID.
Although this operation behaves like a PATCH (updating specific fields), it uses a PUT because it entirely replaces the values related to the calculator inputs.
Input Parameters:
Energy Consumption: User's energy usage in kWh.
Transportation: Details of distances traveled and types of transportation used.
Solid Waste Production: Amount of solid waste produced, along with the recycling percentage (recyclePercentage as a value between 0 and 1.0).
The calculation data is saved as a new version in the database, overwriting any previous values for the same calculation ID.
If called multiple times for the same ID, the existing data will be replaced with the new values provided.
Behavior: Ensures data consistency by maintaining a single, updated record for each calculation.

### [GET] /calculator/{id}

Retrieves the detailed carbon footprint calculation for the given calculation ID.
Behavior:
Performs a direct query to the database to fetch the stored calculation data associated with the provided id.
The retrieved database object is then mapped into a DTO (Data Transfer Object) using a dedicated mapper, ensuring a clean and consistent response structure for the client.
Output: Returns a well-structured DTO containing the calculated carbon footprint, including:
Total emissions for energy consumption.
Emissions from transportation.
Emissions from solid waste.
A summary of the total carbon footprint.
This approach abstracts database structures and ensures flexibility for future modifications to the response format without affecting the underlying database schema.

## Calculator logic

There are emission factors already saved in the database for energy consumption (`EnergyEmissionFactor.class`),
transportation (`TransportationEmissionFactor.class`) and solid waste (`SolidWasteEmissionFactor.class`). These factors
must be used to calculate the full carbon emission for this user, according to the following formulas:

### Energy consumption

The class `EnergyEmissionFactor` contains the emission factors for each brazilian state (UF). The emission follows the
formula:

```Carbon emission = energy consumption * emission factor```

### Transportation

The class `TransportationEmissionFactor` contains the emission factors for each type of transportation. The emission
follows the formula:

```Carbon emission = distance * transportation type emission factor```

### Solid waste

The class `SolidWasteEmissionFactor` contains the emission factors for recyclable and non-recyclable solid waste. The
emission follows the formula:

```Carbon emission = solid waste production * emission factor```

## Technical Notes

### Database

Run `docker compose up` to start the MongoDB database. The database will be populated with the default collection
contents defined in the `init-mongo.js` script when first started - all default emission factors are here. These values
are only for this test and should not be
considered real values for carbon emissions :smile:

### Running the application

You can use your IDE of choice to run the application. The main class is `CarbonCalculatorApplication`. The server will
run
on port 8085 (http://localhost:8085).

There is a swagger documentation available on http://localhost:8085/swagger-ui.html.

