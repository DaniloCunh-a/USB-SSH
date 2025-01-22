import sys
from setuptools import setup

setup(
        name="Teste-SPI",
        version="1.0",
        packages=["spitest"],
        author="Danilo Cunha",
        author_email="danilo.cunha@outlook.com",
        description="Teste para um SPI - RFID-RC522",
        license="MIT",
        keywords= "SPI",
        url="https://github.com/DaniloCunh-a",
        entry_points = {"console_scripts":["spitest = spitest.main:main"]},
        install_requires=[
            'mfrc522',  # Adiciona a dependência do mfrc522
            # Outras dependências podem ser listadas aqui
        ],
        )
