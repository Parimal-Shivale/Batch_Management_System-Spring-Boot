/////////////////////////////////////////////////////////////////////////////
//
// File         : BatchEntryController.java
// Description  : This REST Controller handles CRUD operations for BatchEntry
// Author       : Parimal Ashok Shivale
// Date Created : 26/06/2025
// Framework    : Spring Boot
//
/////////////////////////////////////////////////////////////////////////////

package com.marvellous.MarvellousPortal.controller;

import com.marvellous.MarvellousPortal.Entity.BatchEntry;
import com.marvellous.MarvellousPortal.service.BatchEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/////////////////////////////////////////////////////////////////////////////
//
// Class Name   : BatchEntryController
// Description  : Exposes REST endpoints for managing BatchEntry data.
// Endpoints    : GET, POST, PUT, DELETE for /batches
//
/////////////////////////////////////////////////////////////////////////////

@RestController
@RequestMapping("/batches")
public class BatchEntryController 
{

    // Injecting the service layer to handle business logic
    @Autowired
    private BatchEntryService batchEntryService;

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : getAll
    // Description   : Retrieves all BatchEntry records
    // URL           : GET /batches
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ////////////////////////////////////////////////////////////////////////

    @GetMapping
    public ResponseEntity<?> getAll() 
    {
        List<BatchEntry> allData = batchEntryService.getAll();

        if ((allData != null) && !allData.isEmpty()) 
        {
            return new ResponseEntity<>(allData, HttpStatus.OK);
        } 
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : createEntry
    // Description   : Creates a new BatchEntry record
    // URL           : POST /batches
    // RequestBody   : BatchEntry object
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ///////////////////////////////////////////////////////////////////////

    @PostMapping
    public ResponseEntity<BatchEntry> createEntry(@RequestBody BatchEntry myentry) 
    {
        try 
        {
            batchEntryService.saveEntry(myentry);
            return new ResponseEntity<>(myentry, HttpStatus.CREATED);
        } 
        catch (Exception eobj) 
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : getBatchEntryById
    // Description   : Fetch a BatchEntry by its ObjectId
    // URL           : GET /batches/id/{myid}
    // PathVariable  : myid - MongoDB ObjectId
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ///////////////////////////////////////////////////////////////////////

    @GetMapping("/id/{myid}")
    public ResponseEntity<BatchEntry> getBatchEntryById(@PathVariable ObjectId myid) 
    {
        Optional<BatchEntry> batchEntry = batchEntryService.findById(myid);

        if (batchEntry.isPresent()) 
        {
            return new ResponseEntity<>(batchEntry.get(), HttpStatus.OK);
        }
        else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : deleteEntryById
    // Description   : Deletes a BatchEntry by its ObjectId
    // URL           : DELETE /batches/id/{myid}
    // PathVariable  : myid - MongoDB ObjectId
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ///////////////////////////////////////////////////////////////////////


    @DeleteMapping("id/{myid}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myid) 
    {
        batchEntryService.deleteById(myid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ////////////////////////////////////////////////////////////////////////
    //
    // Function Name : updateEntryById
    // Description   : Updates a BatchEntry's name and fees by its ObjectId
    // URL           : PUT /batches/id/{myid}
    // PathVariable  : myid - MongoDB ObjectId
    // Author        : Parimal Ashok Shivale
    // Date          : 26/06/2025
    //
    ///////////////////////////////////////////////////////////////////////

    @PutMapping("id/{myid}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId myid, @RequestBody BatchEntry myentry) 
    {
        BatchEntry old = batchEntryService.findById(myid).orElse(null);

        if (old != null) 
        {
            old.setName(myentry.getName());
            old.setFees(myentry.getFees());

            batchEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        } 
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
