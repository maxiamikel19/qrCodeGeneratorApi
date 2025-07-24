package com.maxiamikel.qrCodeGeneratorApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxiamikel.qrCodeGeneratorApi.entity.Texto;

public interface TextoRepository extends JpaRepository<Texto, Long> {

}
