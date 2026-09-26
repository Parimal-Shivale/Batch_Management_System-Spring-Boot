/////////////////////////////////////////////////////////////////////////////
//
// File         : BatchEntryRepository.java
// Description  : Repository interface for BatchEntry entity
// Author       : Parimal Ashok Shivale
// Date Created : 26/06/2025
// Framework    : Spring Boot + MongoDB
//
/////////////////////////////////////////////////////////////////////////////

package com.marvellous.MarvellousPortal.Repository;

import com.marvellous.MarvellousPortal.Entity.BatchEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//////////////////////////////////////////////////////////////////////////////
//
// Interface Name : BatchEntryRepository
// Description    : Repository interface for performing CRUD operations on
//                  BatchEntry documents in MongoDB. Inherits common methods
//                  from MongoRepository like save, findById, findAll, deleteById.
// Author         : Parimal Ashok Shivale
// Date           : 26/06/2025
//
//////////////////////////////////////////////////////////////////////////////

public interface BatchEntryRepository extends MongoRepository<BatchEntry, ObjectId> 
{
    
}
