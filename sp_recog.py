import speech_recognition as sr

rec_vocale = sr.Recognizer()
mic = sr.Microphone()

with mic as src:
    rec_vocale.adjust_for_ambient_noise(src) # Ajuster au bruit ambiant
    while True:
        audio = rec_vocale.listen(src) # Ecoutez le microphone
        try:
            texte = rec_vocale.recognize_google(audio, language = 'fr', show_all=True) # Utiliser la reconnaissance vocale
        except:
            texte = "Erreur"
        print(texte)