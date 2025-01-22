#!/bin/bash

# Obtém o IP do dispositivo - interface usb0
DEVICE_IP=$(ip addr show usb0 | grep 'inet ' | awk '{print $2}' | cut -d/ -f1)

# Obtém o SN - Processador
PROCESSOR_ID=$(cat /proc/cpuinfo | grep Serial | awk '{print $3}')

# Define o IP do Windows e usuário
WINDOWS_IP="192.168.44.250"
WINDOWS_USER="LSE"

# Define o caminho do arquivo de log no Windows
FLAG_PATH="/mnt/Downloads/image/TPD/log/${DEVICE_IP}.log"

# Monta o sistema de arquivos remoto via SSH
#sshfs -o IdentityFile=/home/root/.ssh/id_som1 ${WINDOWS_USER}@${WINDOWS_IP}: /mnt && \

# Executa o update do sistema
#swupdate -i /mnt/Downloads/image/TPD/update-image-tpd.swu -e "stable,alt" && \

# Redimensiona a partição
#resize2fs /dev/mmcblk1p8

# Cria o arquivo de sinalização para indicar que o update foi finalizado
echo "UPDATE finalizado do SERIAL: $PROCESSOR_ID " > ${FLAG_PATH}

# Desmonta o sistema de arquivos remoto
umount /mnt
