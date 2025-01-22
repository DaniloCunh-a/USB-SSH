from mfrc522 import SimpleMFRC522
import time

# Configuração da biblioteca e do leitor RFID
reader = SimpleMFRC522()

try:
    print("Aproxime o cartão/tag RFID para leitura...")
    while True:
        # Lê o ID da tag
        id, text = reader.read()
        print(f"ID do cartão: {id}")
        if text.strip():
            print(f"Texto no cartão: {text.strip()}")
        else:
            print("Nenhum texto armazenado no cartão.")

        print("\nAproxime outro cartão ou pressione Ctrl+C para sair.")
        time.sleep(2)  # Pequena pausa para evitar leituras repetidas
except KeyboardInterrupt:
    print("\nEncerrando o programa...")