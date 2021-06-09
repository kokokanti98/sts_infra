package com.example.demo.qrcode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QrcodeRepository extends CrudRepository<Qrcode, String> {
    @Query("SELECT new com.example.demo.qrcode.QrcodeJoin(qr.id,qr.reduction,qr.article.id,qr.article.prix,qr.article.name) FROM Qrcode qr")
    List<QrcodeJoin> findAllQrcodeWithReduction();

    @Query("SELECT new com.example.demo.qrcode.QrcodeJoin(qr.id,qr.reduction,qr.article.id,qr.article.prix,qr.article.name) FROM Qrcode qr WHERE qr.id=:id")
    Optional<QrcodeJoin> findWithRedById(@Param("id") String id);
}
