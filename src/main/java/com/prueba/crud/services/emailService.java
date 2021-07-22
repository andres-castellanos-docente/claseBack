package com.prueba.crud.services;

import com.prueba.crud.requests.emailBodyRequest;

public interface emailService {
    public Boolean sendEmail(emailBodyRequest emailBody);
}
