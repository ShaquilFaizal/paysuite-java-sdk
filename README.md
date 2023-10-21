<p align="center"><img src="https://img.shields.io/badge/License-Apache_2.0-blue.svg" alt="License"></a> </p>

# Paysuite-java-sdk
This is a library aiming to help you to integrate the [PaySuite](https://paysuite.co.mz/) operations to your application.

<br>

## Requirements
To make the most of this library, make sure to have the following prerequisites ready:
- Acquire the necessary credentials by registering on the [PaySuite portal](https://paysuite.co.mz/register)

<br>

## Installation

<br>

### Using Gradle

1. Add jitpack to your root `build.gradle` file, under `repositories`:
    ```groovy
    repositories {
        // ... other repositories here ...
        maven { url 'https://jitpack.io' }
    }
    ```

2. Add the dependency:
    ```groovy
    dependencies {
        implementation 'com.github.hypertech-lda:paysuite-java-sdk:1.0.0'
    }
    ```
<br>

### Using Maven

1. Add jitpack to your `pom.xml` file, under `repositories`:
    ```xml
    <repositories>
       <repository>
           <id>jitpack.io</id>
           <url>https://jitpack.io</url>
       </repository>
    </repositories>
    ```

2. Add the dependency:
    ```xml
    <dependency>
       <groupId>com.github.hypertech-lda</groupId>
       <artifactId>paysuite-java-sdk</artifactId>
       <version>1.0.0</version>
    </dependency>
    ```

<br>

### Manual Installation
```bash
git clone https://github.com/hypertech-lda/paysuite-java-sdk
```

<br><br>

## Usage

Using this SDK is very simple and fast, let us see some examples:

```java
import mz.co.hypertech.paysuitejavasdk.Client;
import mz.co.hypertech.paysuitejavasdk.PaySuiteRequest;


        Client client = new Client(apiKey);

        PaySuiteRequest request = new PaySuiteRequest.Builder()
        .tx_ref("REF001")
        .currency("MZN")
        .is_test("1")
        .purpose("Invoice Payment")
        .amount(100.0)
        .callback_url("http://domain.com/callback_url")
        .redirect_url("http://domain.com/invoice.php")
        .build();

// Synchronous Call
        try{
        PaySuiteResponse response = client.initiatePaymentSync(request);
        // Handle success scenario
        }catch(Exception e){
        // Handle failure scenario
        }

// Asynchronous Call
        client.initiatePaymentAsync(request,new ResponseListener(){
@Override
public void onSuccess(PaySuiteResponse response){
        // Handle success scenario
        }

@Override
public void onError(PaySuiteResponse errorResponse){
        // Handle failure scenario
        }
   });
```

## Authors <a name="authors"></a>

- [Name](https://github.com/username)

<br>
