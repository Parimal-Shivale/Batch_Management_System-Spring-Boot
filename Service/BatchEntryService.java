/////////////////////////////////////////////////////////////////////////////
//
// File         : BatchEntryService.java
// Description  : Service layer class for managing BatchEntry business logic
// Author       : Parimal Ashok Shivale
// Date Created : 26/06/2025
// Framework    : Spring Boot + MongoDB
//
/////////////////////////////////////////////////////////////////////////////

package com.marvellous.MarvellousPortal.service;

import com.marvellous.MarvellousPortal.Entity.BatchEntry;
import com.marvellous.MarvellousPortal.Repository.BatchEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/////////////////////////////////////////////////////////////////////////////
//
// Class Name    : BatchEntryService
// Description   : Service class that provides business logic for managing
//                 BatchEntry records. It acts as a bridge between the
//                 controller and repository layers.
// Author        : Parimal Ashok Shivale
// Date          : 26/06/2025
//
///////////////////////////////////////////////////////////////////////////

@Component
public class BatchEntryService 
{

    @Autowired
    private BatchEntryRepository batchEntryRepository;

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : saveEntry
    // Description   : Saves a new BatchEntry or updates an existing one.
    // Input         : BatchEntry object
    // Output        : void
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ////////////////////////////////////////////////////////////////////////

    public void saveEntry(BatchEntry batchEntry) 
    {
        batchEntryRepository.save(batchEntry);
    }

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : getAll
    // Description   : Retrieves all batch entries from the database.
    // Input         : None
    // Output        : List<BatchEntry>
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ////////////////////////////////////////////////////////////////////////

    public List<BatchEntry> getAll() 
    {
        return batchEntryRepository.findAll();
    }

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : findById
    // Description   : Finds a BatchEntry by its ObjectId.
    // Input         : ObjectId (MongoDB ID)
    // Output        : Optional<BatchEntry>
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ////////////////////////////////////////////////////////////////////////


    public Optional<BatchEntry> findById(ObjectId id) 
    {
        return batchEntryRepository.findById(id);
    }

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : deleteById
    // Description   : Deletes a BatchEntry by its ObjectId.
    // Input         : ObjectId (MongoDB ID)
    // Output        : void
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ////////////////////////////////////////////////////////////////////////


    public void deleteById(ObjectId id) 
    {
        batchEntryRepository.deleteById(id);
    }
}
