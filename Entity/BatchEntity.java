/////////////////////////////////////////////////////////////////////////////
//
// File         : BatchEntry.java
// Description  : This class represents a MongoDB document for batch details
// Author       : Parimal Ashok Shivale
// Date Created : 26/06/2025
// Framework    : Spring Boot + MongoDB + Lombok
//
/////////////////////////////////////////////////////////////////////////////

package com.marvellous.MarvellousPortal.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

///////////////////////////////////////////////////////////////////////////
//
// Class Name   : BatchEntry
// Description  : Entity class that maps to the "BatchDetails" collection
//                in MongoDB. Represents a batch with its name and fees.
// Annotations  :
//   @Data      - Generates getters, setters, toString, equals, hashCode
//   @Document  - Maps the class to a MongoDB collection
// Author       : Parimal Ashok Shivale
// Date         : 26/06/2025
//
///////////////////////////////////////////////////////////////////////////

@Data
@Document(collection = "BatchDetails")
public class BatchEntry
{

    // Unique identifier for the batch (MongoDB ObjectId)
    private ObjectId id;

    // Name of the batch (e.g., Java, Python, Data Science)
    private String name;

    // Fees associated with the batch
    private int fees;
}
