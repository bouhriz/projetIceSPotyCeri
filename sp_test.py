import speech_recognition as sr # pip3 install SpeechRecognition

rec_vocale = sr.Recognizer()
fichier = "joyeux.wav", "fr-FR"

with sr.AudioFile(fichier[0]) as src: # Ouvre le fichier
    audio = rec_vocale.record(src) # Donne a rec_vocale
    texte = rec_vocale.recognize_google(audio, language=fichier[1]) # Traduction
    print(texte) # Imprime texte